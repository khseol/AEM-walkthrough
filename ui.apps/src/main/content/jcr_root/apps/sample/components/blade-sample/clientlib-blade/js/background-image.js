/**
 * the goal is to taken in the required images from the dialog and put them in a list.
 * the list will be formed from the back-end.
 * and the javascript will handle ONLY displaying the images.
 */
//function will be served the current image to be shown...so i need to grab the image from the backend.
//the problem will when to call the js function to call to the backend after the schedule runs.

// 'let' or 'var' is used so that the variable can identified as a global variable.
let listOfImages = []; //create an ArrayList to keep the values and iterate over them

window.addEventListener('load',(event) =>{
    console.log('DOM fully loaded and parsed');
	let paths = jQuery('#image_container'); //using jQuery to grab the element that has the uniquw ID value
	console.log("List of paths: "+paths); //this returns an [object Object]
	//...so
	
	jQuery.each(paths.data('img-refs'), function(index, value){
        if(!listOfImages.includes(value)){
			listOfImages.push(value);
        }
	});

	console.log(listOfImages);
});