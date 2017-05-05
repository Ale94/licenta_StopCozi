/**
 * Created by Alexandra Petcov on 03/10/2017.
 */

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
       minDate: '0',
       startDate: '-0m',
       daysOfWeekDisabled : [0,6],
       todayHighlight: true
   });

    $('#submitAppointment').click(function () {
        confirm();
    });
    
    
    $('#location').change(
			function() {
				$.getJSON("http://localhost:8181/appointment/agencies", {
					cityId : $(this).val(),
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
			});


    $('#agency').change(
			function() {
				$.getJSON("http://localhost:8181/appointment/services", {
					agencyName : $(this).val(),
					ajax : 'true'
				}, function(data) {
					var html = '<option value="">--alege servicu--</option>';
					var len = data.length;
					for ( var i = 0; i < len; i++) {
						html += '<option mydoc="'+ data[i].acteNecesare +'" + value="' + data[i].name + '">'
								+ data[i].name + '</option>';
					}
					html += '</option>';
					$('#service').html(html);
				});
			});
       
  
    $("#service").change(
    function(){
		var selected = $("#service option:selected");		
		var output = "";
		if(selected.val() != 0){
			output = selected.attr("mydoc")
		}
		$("#documents").html(output);
	});

    $('#datepicker').change(
			function() {
				var queryString = $('#appointmentForm').serialize();
				var arr = queryString.split('&');
				var agency=arr[2].split("=");
				var agencyName=agency[1].replace("+", " ");
				var service=arr[3].split("=");
				var serviceName=service[1].replace("+", " ");
				$.getJSON("http://localhost:8181/appointment/datepickerHours", {
					data : $(this).val(),
					agencyName: agencyName,
					serviceName: serviceName,
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
			});


});


