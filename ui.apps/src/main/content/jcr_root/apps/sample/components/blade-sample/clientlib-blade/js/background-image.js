/**
 * the goal is to taken in the required images from the dialog and put them in a list.
 * the list will be formed from the back-end.
 * and the javascript will handle ONLY displaying the images.
 */
//function will be served the current image to be shown...so i need to grab the image from the backend.
//the problem will when to call the js function to call to the backend after the schedule runs.

// 'let' or 'var' is used so that the variable can identified as a global variable.
var listOfImages = []; //create an ArrayList to keep the values and iterate over them
var currentIndex = 1; //this will vreak when a user tries to set the current index to any number out of bounds of what was defined in list
window.addEventListener('load',(event) =>{
    console.log('DOM fully loaded and parsed');
	let paths = $('#image_container'); //using jQuery to grab the element that has the unique ID value

	//...so

	//parameters that the .each method takes in is the function that will using key,value pairs 
	//(if one variable present in function, it's automatically seen as a INDEX or KEY, type intergers)
	$(paths.data('img-refs')).each(function(key, value){ //grab the element's data-* attribute to ITERATE OVER
			if(!listOfImages.includes(value)){
				listOfImages.push(value);
			}
        }
	);

	let backgroundElement = document.querySelector('.background_container'); //grabbing the class name of the container
	backgroundElement.style.setProperty('--set-image', 'url('+listOfImages[0]+')'); //enables the changing of the pseudo element css properties.

	//running function that is set to call a function every 5 seconds.
	setInterval(function (){
	if (currentIndex == listOfImages.length-1){
		currentIndex = 0;
	}else {
		currentIndex+=1;
	}
    //console.log("current background is: "+ listOfImages[currentIndex]);
	let backgroundElement = document.querySelector('.background_container'); //grabbing the class name of the container
	backgroundElement.style.setProperty('--set-image', 'url('+listOfImages[currentIndex]+')'); //changes the image every 5 seconds.
}, 5000);




	//let currentindex = 0;
	//console.log(listOfImages[1]); //this is working
//$('.background_conatiner').css({'background-image': 'url('+listOfImages[1]+')',
//                               'background-size' : 'cover',			
//                               'width' : '100%',
//                               'height': '50%',
//                               'opacity':'0.7'
//                                });
});
