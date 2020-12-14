<?php 

    error_reporting(E_ALL); 
    ini_set('display_errors',1); 

    include('dbcon.php');


    $android = strpos($_SERVER['HTTP_USER_AGENT'], "Android");


    if( (($_SERVER['REQUEST_METHOD'] == 'POST') && isset($_POST['submit'])) || $android )
    {

        // 안드로이드 코드의 postParameters 변수에 적어준 이름을 가지고 값을 전달 받습니다.

        $name=$_POST['name'];
        $category=$_POST['category'];

        if(!isset($errMSG)) // 데이터가 모두 입력되면
        {
            try{
                // SQL문을 실행하여 데이터를 MySQL 서버의 donate 테이블에 저장합니다. 
                $stmt = $con->prepare('INSERT INTO donate(name, category) VALUES(:name, :category)');
                $stmt->bindParam(':name', $name);
                $stmt->bindParam(':category', $category);

                if($stmt->execute())
                {
                    $successMSG = "새로운 데이터를 추가했습니다.";
                }
                else
                {
                    $errMSG = "데이터 추가 에러";
                }

            } catch(PDOException $e) {
                die("Database error: " . $e->getMessage()); 
            }
        }

    }

?>


<?php 
    if (isset($errMSG)) echo $errMSG;
    if (isset($successMSG)) echo $successMSG;

    $android = strpos($_SERVER['HTTP_USER_AGENT'], "Android");
   
    if( !$android )
    {
?>
    <html>
       <body>

            <form action="<?php $_PHP_SELF ?>" method="POST">
                Name: <input type = "text" name = "name" />
                Country: <input type = "text" name = "country" />
                <input type = "submit" name = "submit" />
            </form>
       
       </body>
    </html>

<?php 
    }
?>