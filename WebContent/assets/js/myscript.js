$(document).ready(function() {
		
});

function showTip(message) {
	var tip = $("#tip");
	tip.append('<div class="tip-item"><div class="message">' + message
			+ '</div></div>')
	var thisItem = tip.children().last();
	$(thisItem.children(".close").eq(0)).bind("click", function() {
		thisItem.slideUp(function() {
			thisItem.remove();
		});
	});
	thisItem.fadeIn();
	setTimeout(function() {
		thisItem.slideUp(function() {
			thisItem.remove();
		});
	}, 3000);
}

function chooseActive(element){
	$(element).addClass("n-active");
	$('#selectNav').children().click(function () {
		$(this).parent().children().removeClass('n-active');
		$(this).addClass('n-active');
    });
}