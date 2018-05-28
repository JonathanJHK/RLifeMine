
(function($){
  $(function(){

    $('.sidenav').sidenav();
    $('.parallax').parallax();
    $('.carousel.carousel-slider').carousel({
    fullWidth: true, 
    indicators: true
  });
    autoplay()   
	function autoplay() {
    $('.carousel').carousel('next');
    setTimeout(autoplay, 5000);
    }

  }); // end of document ready
})(jQuery); // end of jQuery name space
