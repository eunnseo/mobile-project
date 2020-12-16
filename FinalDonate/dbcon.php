<?php

	$host = '';
	$username = '';
	$password = '';
	$dbname = 'goodsdb';

	$options = array(PDO::MYSQL_ATTR_INIT_COMMAND => 'SET NAMES utf8');
    
    try {

        $con = new PDO("mysql:host={$host};dbname={$dbname};charset=utf8",$username, $password);
    } catch(PDOException $e) {

        die("Failed to connect to the database: " . $e->getMessage()); 
    }


    $con->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
    $con->setAttribute(PDO::ATTR_DEFAULT_FETCH_MODE, PDO::FETCH_ASSOC);

    if (!empty($array)) {
        foreach($array as &$value) { 
            if(is_array($value)) { 
                undo_magic_quotes_gpc($value); 
            } 
            else { 
                $value = stripslashes($value); 
            } 
        } 
    }
 
    header('Content-Type: text/html; charset=utf-8'); 
    #session_start();
?>