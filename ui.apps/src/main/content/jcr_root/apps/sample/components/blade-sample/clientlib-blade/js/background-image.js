/**
 * the goal is to taken in the required images from the dialog and put them in a list.
 * the list will be formed from the back-end.
 * and the javascript will handle ONLY displaying the images.
 */
//function will be served the current image to be shown...so i need to grab the image from the backend.
//the problem will when to call the js function to call to the backend after the schedule runs.

function loadBackground(){
    console.log('DOM fully loaded and parsed');
	var imagePath = "";
	$.get("/bin/backgroundServlet", {check:"true"}, function(e){
    	console.log(e);
	})
};