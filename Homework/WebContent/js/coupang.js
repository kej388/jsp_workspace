/**
 * 
 */$(function check() {

    var emailRule = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
    

    $("input#pwd").click(function(){
        if($("#emailId").val() == ""){
            $(".emailIdText").css("display", "block");
            return;
        }
        if(!emailRule.test($("#emailId").val())) {            
            alert("email형식이 일치하지 않습니다.");
            return;
        }
    })

    $("#pwdchk").click(function(){
        if($("#pwd").val() == ""){
            $(".pwdText").css("display", "block");
            return;
        }
    })

    $("#name").click(function(){
        if($("#pwd").val() == ""){
            $(".pwdText").css("display", "block");
            return;
        } else {
            if($("#pwd").val() != $("#pwdchk").val()){
                $(".pwdchkText").css("display", "block");
                return;
            }
        }
    })

    $("#phone").click(function(){
        if($("#name").val() == ""){
            $(".nameText").css("display", "block");
            return;
        }
    })
})
$(function(){
    $("textarea").on("keyup", function(){
        if($(this).val().length > 150){
            $(this).val($(this).val().substring(0, 150));
        }
    })
})