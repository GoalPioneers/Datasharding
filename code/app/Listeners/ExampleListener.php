<?php
    namespace App\Listeners;

    use App\Events\ExampleEvent;
    use Illuminate\Contracts\Queue\ShouldQueue;
    use Illuminate\Queue\InteractsWithQueue;


    class ExampleListener
    {

        public function __construct()
        {
            //
        }


        public function handle( ExampleEvent $event )
        {
            //
        }
    }
?>