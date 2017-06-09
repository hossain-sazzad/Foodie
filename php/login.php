<?php
    $con = mysqli_connect("localhost", "root", "", "foodie_register");
    
    $username = $_POST["loginname"];
    
    $password = $_POST["loginpass"];
    $query="select username from register where username like'$username' and password like '$password';";
$result=mysqli_query($con,$query);
if(mysqli_num_rows($result)>0)
{
$row=mysqli_fetch_assoc($result);
$name=$row["username"];
echo"Login success...".$name;
}
else
{
echo"Login failed, Try again";
}
?>