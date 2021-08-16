/**
 * the goal is to taken in the required images from the dialog and put them in a list.
 * the list will be formed from the back-end.
 * and the javascript will handle ONLY displaying the images.
 */
//function will be served the current image to be shown...so i need to grab the image from the backend.
//the problem will when to call the js function to call to the backend after the schedule runs.

// 'let' or 'var' is used so that the variable can identified as a global variable.
var listOfImages = []; //create an ArrayList to keep the values and iterate over them

window.addEventListener('load',(event) =>{
    console.log('DOM fully loaded and parsed');
	let paths = $('#image_container'); //using jQuery to grab the element that has the unique ID value

	//...so

	//using jquery .get method to iterate over DOM elements.
	//parameters that the .each method takes in is the function that will using key,value pairs 
	//(if one variable present in function, it's automatically seen as a INDEX or KEY, type intergers)
	$(paths.data('img-refs')).each(function(key, value){ //grab the element's data-* attribute to ITERATE OVER
			if(!listOfImages.includes(value)){
				listOfImages.push(value);
			}
        }
	);
	var testUrl = 'url('+listOfImages[1]+')';
	
	//the code below will not work since a CSSStyleDeclatation inteface is returned through 'getComputedStyles', the line is a READ ONLY
	//window.getComputedStyle($('.background_container'), '::before').setProperty('backrgound-image', testUrl);


//	let currentindex = 0;
//	console.log(listOfImages[1]); //this is working
//$('.background_conatiner').css({'background-image': 'url('+listOfImages[1]+')',
//                               'background-size' : 'cover',			
//                               'width' : '100%',
//                               'height': '50%',
//                               'opacity':'0.4'
//                                });
});