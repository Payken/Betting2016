/**
 * Created by fdarmoch on 2016-01-07.
 */
$( document ).ready(function() {   function clearForm(AForm)
{
    for (i = 0; i < AForm.elements.length; i++) {
        if (AForm.elements[i].type == "radio") {
            AForm.elements[i].checked = false;
        } else if (AForm.elements[i].type == "checkbox") {
            AForm.elements[i].checked = false;
        } else if (AForm.elements[i].type == "text") {
            AForm.elements[i].value = '';
        } else if (AForm.elements[i].type == "password") {
            AForm.elements[i].value = '';
        } else if (AForm.elements[i].type == "select-one") {
            AForm.elements[i].selectedIndex = 0;
        } else if (AForm.elements[i].type == "select-multiple") {
            AForm.elements[i].selectedIndex = -1;
        }
    }
    return true;
}  });