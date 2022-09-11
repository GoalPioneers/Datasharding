<?php
    use Illuminate\Database\Migrations\Migration;
    use Illuminate\Database\Schema\Blueprint;
    use Illuminate\Support\Facades\Schema;


    return new class extends Migration
    {

        public function up()
        {
            //
            Schema::create('accounts',
                function ( Blueprint $table )
                {
                    $table->id();

                    $table->string( 'username' )
                          ->index();

                    $table->bigInteger( 'email_idx' )
                          ->unsigned()
                          ->index();
                    
                    $table->string( 'password' );

                    $table->timestamp( 'created_at' );
                    $table->timestamp( 'updated_at' );

                    $table->foreign( 'email_idx' )
                        ->references( 'id' )
                        ->on( 'person_emails' );
                }
            );
        }


        public function down()
        {
            //
            Schema::drop( 'accounts' );
        }
    };
?>