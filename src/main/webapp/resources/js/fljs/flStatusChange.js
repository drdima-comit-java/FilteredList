// $("#fldsId-1").click(
//     function(){
//         alert('hello');
//     },
//     {
//
//         ajax: {
//             type: 'POST',
//             contentType: 'application/json; charset=utf-8',
//             url: '',
//             dataType: 'json',
//             data: JSON.stringify(search),
//             success: function(result){
//                 alert(result);
//             }
//
//         }
//
//     }
// );



var printError = function(error, explicit) {
    alert( error.name + ':' + error.message);
}

var inProgress=false;

$(
    function()
    {
        $('[data-flds-id]').on
        (
            'click', function(e)
            // {
            //     e.preventDefault();
            //     alert(    ($(this).data('flds-id'))   );
            // },
            {
                if (inProgress==false || ($(this).data('flds-sort'))==2 ) {
                    var element = this;
                    $.ajax(
                        {
                            type: 'POST',
                            contentType: 'application/json; charset=utf-8',
                            url: '/filtered-list-details-change-status/' + ($(this).data('flds-id')) + '/' + ($(this).data('fld-id')),
                            dataType: 'json',
                            //dataType: 'html',
                            //data: JSON.stringify(search),
                            data: "",
                            success: function (flds) {
                                //alert(flds);
                                try {
                                    //var fld = JSON.parse(result);

                                }
                                catch (e) {
                                    if (e instanceof SyntaxError) {
                                        printError(e, true);
                                    } else {
                                        printError(e, false);
                                    }
                                }


                                //alert(flds.fldsName);
                                //alert(flds.fldsCss);
                                ($(element)).data('flds-id', flds.fldsId);
                                ($(element)).data('flds-sort', flds.fldsSort);
                                ($(element)).text(flds.fldsName);
                                ($(element)).attr('class', flds.fldsCss);

                                if (flds.fldsSort == 2) {
                                    inProgress = true;
                                    if ( ($(element).data('fld-apps-path'))) {
                                        runApp(($(element).data('fld-id')));
                                    }
                                }
                                else {
                                    inProgress = false;
                                }
                            }


                        });
                }
                else{
                    alert ("Instalation in progress");
                }
                //alert(    ($(this).data('flds-id'))   );
            }

        )
    }
 );


function runApp(fldId)
{
    //alert ('in runapp');
    //WshShell = new ActiveXObject("WScript.Shell");
    //var ret= WshShell.Run("c:/__testjs/test.bat param1", 1, true);
    //var ret= WshShell.Run("\\\\server\\u_ro\\write.exe", 1, false);

    //window.open('/resources/tmp/run.bat', "", "width=0,height=0")
    window.open('/download/' + fldId, "_self");
    //alert (ret);
}



$(
    function()
    {
        $('.open-AddAppDialog').on('click', function e() {
            var myAppName = $(this).data('apps-name');
            //alert(myAppName);
            $(".modal-body #appsName").val(myAppName);
            //$("#form-modal-body").attr("action", "/add-app/filtered-list-details-view/73");;
            // As pointed out in comments,
            // it is superfluous to have to manually call the modal.
            // $('#addBookDialog').modal('show');
        })
});
























/*
//navbar highlight
$(function() {
    $(".nav a").on("click", function () {

        $(".nav").find(".active").removeClass("active");

        console.log($(this).parent().text());
        $(this).parent().addClass("active");
    });
});
*/


//navbar hightlight by url
$(document).ready(function() {
    // get current URL path and assign 'active' class
    var pathname = window.location.pathname;
    $('.nav > li > a[href="'+pathname+'"]').parent().addClass('active');
})




