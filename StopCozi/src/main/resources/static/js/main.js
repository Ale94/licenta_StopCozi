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


    $(".form_datetime").datetimepicker({
    	defaultDate: new Date(),
    	format: "yyyy-mm-dd hh:mm",
        autoclose: true,
        todayBtn: true,
        startDate: "2017-03-21",        
        minuteStep: 15
    });

    $('#submitAppointment').click(function () {
        confirm();
    });

});




