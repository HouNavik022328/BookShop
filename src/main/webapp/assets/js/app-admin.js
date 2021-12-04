//navbar



$(document).ready(function () {
    // Activate tooltip
    $('[data-toggle="tooltip"]').tooltip();

    // Select/Deselect checkboxes
    var checkbox = $('table tbody input[type="checkbox"]');
    $("#selectAll").click(function () {
        if (this.checked) {
            checkbox.each(function () {
                this.checked = true;
            });
        } else {
            checkbox.each(function () {
                this.checked = false;
            });
        }
    });
    checkbox.click(function () {
        if (!this.checked) {
            $("#selectAll").prop("checked", false);
        }
    });
});


$(document).on("click", ".edit", function () {
    var id = $(this).data('id');
    var name = $(this).data('name');
    var author = $(this).data('author');
    var address = $(this).data('address');
    var phone = $(this).data('phone');
    var email = $(this).data('email');
    var password = $(this).data('password');
    var date = $(this).data('date');
    
    $(".modal-body #id").val(id);
    $(".modal-body #name").val(name);
    $(".modal-body #author").val(author);
    $(".modal-body #address").val(address);
    $(".modal-body #phone").val(phone);
    $(".modal-body #email").val(email);
    $(".modal-body #password").val(password);
    $(".modal-body #date").val(date);
});

$(document).on("click", ".delete", function () {
    var id = $(this).data('id');
    
    $(".modal-footer #delete-id").val(id);
   
});

//popup
jQuery(document).ready(function($){
  
  window.onload = function (){
    $(".bts-popup").addClass('is-visible');
	}
  
	//open popup
	$('.bts-popup-trigger').on('click', function(event){
		event.preventDefault();
		$('.bts-popup').addClass('is-visible');
	});
	
	//close popup
	$('.bts-popup').on('click', function(event){
		if( $(event.target).is('.bts-popup-close') || $(event.target).is('.bts-popup') ) {
			event.preventDefault();
			$(this).removeClass('is-visible');
		}
	});
	//close popup when clicking the esc keyboard button
	$(document).keyup(function(event){
    	if(event.which=='27'){
    		$('.bts-popup').removeClass('is-visible');
	    }
    });
});

//end popup

//add product 
$(document).on("click", ".edit-product", function () {
    var id = $(this).data('id');
    var category = $(this).data('category');
    var name = $(this).data('name');
    var author = $(this).data('author');
    var price = $(this).data('price');
    var discount = $(this).data('discount');
    var description = $(this).data('description');
    var image = $(this).data('image');
    var quantity = $(this).data('quantity');
    var available = $(this).data('available');
    var condition = $(this).data('condition');
    var date = $(this).data('date');
    
    $(".modal-body #product-id").val(id);
    $(".modal-body #product-name").val(name);
    $(".modal-body #product-author").val(author);
    $(".modal-body #product-price").val(parseFloat(price));
    $(".modal-body #product-discount").val(parseInt(discount));
    $(".modal-body #product-description p").val(description);
//    $(".mce-content-body p").val(description);
    tinyMCE.activeEditor.setContent(description);
    $(".modal-body #product-image").val(image);
    $(".modal-body #preview-product-image-up").attr("href", image);
    $(".modal-body #product-image-update").val(image);
    $(".modal-body #product-quantity").val(parseInt(quantity));
    $(".modal-body #date").val(date);
});

$(document).on("click", ".delete-product", function () {
    var id = $(this).data('id');
    
    $(".modal-footer #delete-id").val(id);
   
});

const nameAdd = document.getElementById("add-product-name");
const nameEdit = document.getElementById("product-name");
const nameNoti = document.getElementById("add-name-noti");
const editNoti = document.getElementById("edit-name-noti");
const submitAdd = document.getElementById("submit-add");
const submitEdit = document.getElementById("submit-edit");
            
nameAdd.onkeyup = validEmptyName; 
nameEdit.onkeyup = validEmptyNameEdit;
        
function validEmptyName() {
    nameNoti.style.display = "none";
    if (nameAdd.value.trim().length === 0) {
        nameNoti.innerHTML = "Name of product can't be empty!";
        nameNoti.style.display = "block";
        submitAdd.disabled = true;
        submitAdd.style.cursor = "not-allowed";
    }
    else {
        nameNoti.innerHTML = "";
        nameNoti.style.display = "none";
        submitAdd.disabled = false;
        submitAdd.style.cursor = "pointer";
    }
}

function validEmptyNameEdit() {
    editNoti.style.display = "none";
    if (nameEdit.value.trim().length === 0) {
        editNoti.innerHTML = "Name of product can't be empty!";
        editNoti.style.display = "block";
        submitEdit.disabled = true;
        submitEdit.style.cursor = "not-allowed";
    }
    else {
        editNoti.innerHTML = "";
        editNoti.style.display = "none";
        submitEdit.disabled = false;
        submitEdit.style.cursor = "pointer";
    }
}



