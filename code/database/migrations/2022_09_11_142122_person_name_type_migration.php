<?php
    use Illuminate\Database\Migrations\Migration;
    use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\DB;
use Illuminate\Support\Facades\Schema;


    return new class extends Migration
    {

        public function up()
        {
            //
            Schema::create('person_name_types',
                function ( Blueprint $table )
                {
                    $table->id();
                    $table->string( 'content' )->unique();
                }
            );
        }


        public function down()
        {
            Schema::drop( 'person_name' );
        }
    };
?>