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
                    success: function (flds)
                    {
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
                        ($(element)).data('flds-id',flds.fldsId);
                        ($(element)).text(flds.fldsName);
                        ($(element)).attr('class',flds.fldsCss);

                    }


                });
                //alert(    ($(this).data('flds-id'))   );
            }

        )
    }
 );



