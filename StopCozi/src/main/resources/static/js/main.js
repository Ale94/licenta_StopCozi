/**
 * Created by Alexandra Petcov on 03/10/2017.
 */


var gvDate;
var gvService;
function populateAgency(paramCityId) {
				resetAgency();
				$.getJSON("http://localhost:8181/appointment/agencies", {
					cityId : paramCityId,
					ajax : 'true'
				}, function(data) {
					var html = '<option value="">--alege agentia--</option>';
					var len = data.length;
					for ( var i = 0; i < len; i++) {
						html += '<option value="' + data[i].nume + '">'
								+ data[i].nume + '</option>';
					}
					html += '</option>';
					$('#agency').html(html);
				});
			}
function resetAgency(){
	var html = '<option value="">--alege agentia--</option>';
	$('#agency').html(html);
	resetService();
}
function resetService(){
	gvService=null;
	var html = '<option value="">--alege serviciu--</option>';
	$('#service').html(html);
	resetDocuments();
	resetHour();
}
function resetDocuments(){
	var html = 'Selectati un serviciu pentru a afla actele necesare.';
	$("#documents").html(html);
}
function resetHour(){
	var html = '<option value="">--alege ora--</option>';
	$('#hour').html(html);
}
function populateService(paramAgencyName) {
	resetService();
	$.getJSON("http://localhost:8181/appointment/services", {
		agencyName : paramAgencyName,
		ajax : 'true'
	}, function(data) {
		var html = '<option value="">--alege servicu--</option>';
		var len = data.length;
		for ( var i = 0; i < len; i++) {
			html += '<option mydoc="'+ data[i].acteNecesare +'"idService="' + data[i].id +'" value="' + data[i].name + '">'
					+ data[i].name + '</option>';
		}
		html += '</option>';
		$('#service').html(html);
	});
}

function populateHours(){
	resetHour();
	if(gvService != null && gvDate!=null){
		var queryString = $('#appointmentForm').serialize();
		var arr = queryString.split('&');
		var agency=arr[2].split("=");
		var agencyName=agency[1].replace("+", " ");
		var service=arr[3].split("=");
		var serviceName=service[1].replace("+", " ");
		$.getJSON("http://localhost:8181/appointment/datepickerHours", {
			data : gvDate,
			agencyName: agencyName,
			serviceName: gvService,
			ajax : 'true'
		}, function(data) {
			var html = '<option value="">--alege ora--</option>';
			var len = data.length;
			for ( var i = 0; i < len; i++) {
				html += '<option value="' + data[i] + '">'
				+ data[i] + '</option>';
			}
			html += '</option>';
			$('#hour').html(html);
		});
	}
}

(function ($) {
    $.toggleShowPassword = function (options) {
        var settings = $.extend({
            field: "#password",
            control: "#toggle_show_password",
        }, options);

        var control = $(settings.control);
        var field = $(settings.field)

        control.bind('click', function () {
            if (control.is(':checked')) {
                field.attr('type', 'text');
            } else {
                field.attr('type', 'password');
            }
        })
    };

}(jQuery));

$(document).ready(function() {
	// at this point the page has been loaded
    var confirm = function() {
        bootbox.confirm({
            title: "Confirmare programare",
            message: "Doriti sa creeati programarea?",
            buttons: {
                cancel: {
                    label: '<i class="fa fa-times"></i> Nu'
                },
                confirm: {
                    label: '<i class="fa fa-check"></i> Da'
                }
            },
            callback: function (result) {
                if (result == true) {
                    $('#appointmentForm').submit();
                } else {
                    console.log("Confirmare anulata.");
                }
            }
        });
    };

    $.toggleShowPassword({
        field: '#password',
        control: "#showPassword"
    });


    $.fn.datepicker.dates['ro'] = {
    	    days: ["Duminica", "Luni", "Marti", "Miercuri", "Joi", "Vineri", "Sambata", "Duminica"],
    	    daysShort: ["Dum", "Lu", "Ma", "Mie", "Joi", "Vin", "Sam", "Dum"],
    	    daysMin: ["Du", "Lu", "Ma", "Mi", "Jo", "Vi", "Sa", "Du"],
    	    months: ["Ianuarie", "Februarie", "Martie", "Aprilie", "Mai", "Iunie", "Iulie", "August", "Septembrie", "Octombrie", "Noiembrie", "Decembrie"],
    	    monthsShort: ["Ian", "Feb", "Mar", "Apr", "Mai", "Iun", "Iul", "Aug", "Sep", "Oct", "Nov", "Dec"],
    	    today: "Azi",
    	    weekStart:1
    	};


   $('#datepicker').datepicker({
//   	defaultDate: new Date(),
       format: "yyyy-mm-dd",
	   autoclose: true,
       language: 'ro',
       startDate: '-0m',
       daysOfWeekDisabled : [0,6],
       todayHighlight: true,
       orientation: 'bottom'
   });

    $('#submitAppointment').click(function () {
        confirm();
    });
    
    
    $('#location').change(
    		function (){
    			populateAgency($(this).val());
    			});


    $('#agency').change(
    		function(){
    			populateService($(this).val());
    		}
			);
       
  
    $("#service").change(
    function(){
		var selected = $("#service option:selected");	
		gvService=selected.val();
		var output = "";
		if(selected.val() != 0){
			output = selected.attr("mydoc")
		}
		$("#documents").html(output);
		populateHours();

	});

    $('#datepicker').change(
			function () {
				gvDate=$(this).val();
				populateHours();
				
			});


});


