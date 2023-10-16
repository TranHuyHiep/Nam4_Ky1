<?php
    trait Hello {
        public function sayHello() {
            echo "Hello";
        }
    }

    trait World {
        public function sayWord() {
            echo "World";
        }
    }

    class MyHelloWord {
        use Hello, World;
        public function sayHelleWorld() {
            echo "!";
        }
    }

    $a = new MyHelloWord();
    $a->sayHello();
    echo " ";
    $a->sayWord();
    $a->sayHelleWorld();

?>