'use strict';

// Java: public class TelaConsulta { }
function TelaConsulta(options) {
  options = options || {};
  this.form = options.form;
  this.textoBusca = options.textoBusca;
  this.listaAlbuns = options.listaAlbuns;
  this.progress = options.progress;
  this.spotify = new Spotify();
}

TelaConsulta.prototype.getIdParaBusca = function(id) {
  var artistaBusca = this.textoBusca.val().toLowerCase();
  return artistaBusca === 'justin bieber' && Math.random() < 0.8 ? 'douchebag' : id;
};

TelaConsulta.prototype.render = function() {
  // lembram-se do comportamento de closures ? dependendo da situação this deixar de ser this..
  // tirando uma selfie...
  var self = this;

  this.form.on('submit', function(e) {
    self.progress.toggleClass('escondido');
    var jaAdicionados = [], artistaBusca = self.textoBusca.val();
    
    self.spotify.pesquisarArtista(artistaBusca).done(function(response) {
      if (response.artists.items.length == 0) {
        alert('Sem resultados encontrados');
        self.progress.toggleClass('escondido');
        return e.preventDefault();
      }
      var idParaPesquisar = self.getIdParaBusca(response.artists.items[0].id);
      self.spotify.obterDetalhesArtista(idParaPesquisar).done(function(response) {
        self.listaAlbuns.empty();
        response.items.forEach(function(i) {
          // lembram de prototype? poderíamos fazer um contains.
          // !jaAdicionados.contains(i.name)
          if (jaAdicionados.indexOf(i.name.toLowerCase()) === -1) {
            self.listaAlbuns.append(
              $('<li>').append(
                $('<img>').attr('src', i.images[1].url)
              )
            );
            console.log(i.name);
            jaAdicionados.push(i.name.toLowerCase());
          }
        });
        self.progress.toggleClass('escondido');
      })
      .fail(function(err) {
        self.listaAlbuns.empty();
        var msg = String.format('Caro usuário, devido a um erro {0}, não foi possível pesquisar por {1}', err.status, artistaBusca);
        alert(msg);
        self.progress.toggleClass('escondido');
      });
    })

    // evitando tratamento padrão do Browser
    return e.preventDefault();
  });
};