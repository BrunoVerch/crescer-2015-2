'use strict';

$(function() {
  var ul = $('#capas-maiden');
  var URL = 'https://api.spotify.com/v1/artists/6mdiAmATAx73kdxrNrnlao/albums?limit=50';
  var jaAdicionados = [];
  // forma mais completa de realizar um ajax
  // lembrem que $.get é uma abreviação para $.ajax({ url, type: 'GET' })
  $.ajax({
    url: URL,
    type: 'GET'
  }).done(function(response) {
    response.items.forEach(function(i) {
      // se contém dentro do array
      if (jaAdicionados.indexOf(i.name.toLowerCase()) === -1) {
        ul.append(
          $('<li>').append(
            // posição 1 == imagem 300x300
            $('<img>').attr('src', i.images[1].url)
          )
        );
        console.log(i.name);
        jaAdicionados.push(i.name.toLowerCase());
      }
    });
  });
});