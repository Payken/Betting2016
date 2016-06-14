<?php
if($_POST)
{
 $to_Email = "salim2110@gmail.com"; //Podaj tu email docelowy
 $subject = 'Ah!! My email from Somebody out there...'; //Tutaj temat wiadomoœci - mo¿esz te¿ wykorzystaæ pole formularza i pobraæ t¹ wartoœæ od klienta
  
  
 //Sprawdzamy czy jest to rz¹danie Ajax, jeœli nie..
 if(!isset($_SERVER['HTTP_X_REQUESTED_WITH']) AND strtolower($_SERVER['HTTP_X_REQUESTED_WITH']) != 'xmlhttprequest') {
  
 //Koñczymy skrypt wysy³aj¹c dane JSON
 $output = json_encode(
 array(
 'type'=>'error', 
 'text' => 'Rz¹danie musi przejœæ przez AJAX'
 ));
  
 die($output);
 } 
  
 //Sprawdzamy czy wszystkie pola zosta³y wys³ane. koñczymy skrypt jeœli nie (tutaj dodawaj wiêcej pól, które s¹ wymagane)
 if(!isset($_POST["userName"]) || !isset($_POST["userEmail"]) || !isset($_POST["userPhone"]) || !isset($_POST["userMessage"]))
 {
 $output = json_encode(array('type'=>'error', 'text' => 'POLA S¥ PUSTE!'));
 die($output);
 }
 
 //Pobieramy dane z formularza
 $user_Name = filter_var($_POST["userName"], FILTER_SANITIZE_STRING);
 $user_Email = filter_var($_POST["userEmail"], FILTER_SANITIZE_EMAIL);
 $user_Phone = filter_var($_POST["userPhone"], FILTER_SANITIZE_STRING);
 $user_Message = filter_var($_POST["userMessage"], FILTER_SANITIZE_STRING);
  
 //Dodatkowa validacja PHP (tylko dla pól wymaganych)
 if(strlen($user_Name)<4) // Wywala b³¹d jeœli imiê ma mniej ni¿ 4 znaki
 {
 $output = json_encode(array('type'=>'error', 'text' => 'Imiê jest za krótkie!'));
 die($output);
 }
 if(!filter_var($user_Email, FILTER_VALIDATE_EMAIL)) //sprawdzamy email
 {
 $output = json_encode(array('type'=>'error', 'text' => 'Proszê podaæ poprawny email!'));
 die($output);
 }
 if(!is_numeric($user_Phone)) //sprawdzamy czy telefon jest numeryczny
 {
 $output = json_encode(array('type'=>'error', 'text' => 'Tylko liczby s¹ dozwolone'));
 die($output);
 }
 if(strlen($user_Message)<5) //Sprawdzamy czy wiadomoœæ ma wiêcej ni¿ 5 znaków
 {
 $output = json_encode(array('type'=>'error', 'text' => 'Wiadomoœæ za krótka! Wpisz coœ jeszcze.'));
 die($output);
 }
  
 //Nag³ówki do Maila
 $headers = 'From: '.$user_Email.'' . "\r\n" .
 'Reply-To: '.$user_Email.'' . "\r\n" .
 'X-Mailer: PHP/' . phpversion();
  
 $sentMail = @mail($to_Email, $subject, $user_Message .' -'.$user_Name, $headers);
  
 if(!$sentMail)
 {
 $output = json_encode(array('type'=>'error', 'text' => 'Nie mo¿na wys³aæ wiadomoœci. SprawdŸ konfiguracjê PHP Mail'));
 die($output);
 }else{
 $output = json_encode(array('type'=>'message', 'text' => 'Witaj '.$user_Name .' Dziêkujê za wiadomoœæ!'));
 die($output);
 }
}
?>