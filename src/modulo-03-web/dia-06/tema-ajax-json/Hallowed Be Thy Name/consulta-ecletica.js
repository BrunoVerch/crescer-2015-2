'use strict';

$(function() {
  $('#formBusca').on('submit', function(e) {
    var textoBusca = $('#formBusca input[name=textoBusca]').val();
    var ul = $('#capas-albuns');
    var self = this;
    var jaAdicionados = [];
    pesquisarArtista(textoBusca).done(function(response) {
      console.log(response.artists.items[0].id);

      obterDetalhesArtista(response.artists.items[0].id)
        .done(function(response) {
          ul.empty();
          response.items.forEach(function(i) {
            if (jaAdicionados.indexOf(i.name.toLowerCase()) === -1) {
              ul.append(
                $('<li>').append(
                  $('<img>').attr('src', i.images[1].url)
                )
              );
              console.log(i.name);
              jaAdicionados.push(i.name.toLowerCase());
            }
          });
        });
    });

    // evitar que o browser execute ação padrão de formulários (que é executar um post e recarregar a página)
    return e.preventDefault();
  });

  var pesquisarArtista = function(texto) {
    console.log('pesquisando por %s', texto);
    var urlBusca = 'https://api.spotify.com/v1/search?q='+ texto +'&type=artist';

    return $.ajax({
      url: urlBusca,
      type: 'GET'
    });
  };

  var obterDetalhesArtista = function(id) {
    var urlConsulta = 'https://api.spotify.com/v1/artists/' + id + '/albums'
    var queryString = { limit: 50 };

    return $.ajax({
      url: urlConsulta,
      type: 'GET'
    }); 
  };
  
});