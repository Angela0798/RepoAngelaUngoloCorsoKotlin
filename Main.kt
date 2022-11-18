
var listadomande: ArrayList<String> = ArrayList()
var listarisposte: ArrayList<String> = ArrayList()
var utente ="angela"
var admin = "admin"
var pass = "1234"


fun main(){

    var ControlloG=true;
    do {
        if(ControlloG==true)
        {
            println("Sei utente(1) ,admin(2) o vuoi uscire(3)?")
            var opzione = readLine()!!.toInt()
            if (opzione == 1) {
                Utente()
            } else if (opzione == 2) {
                Admin()
            }
            else if(opzione==3)
            {
                ControlloG=false
            }
                else if (opzione != 1 && opzione != 2 && opzione!=3)
                println("Inserisci l'opzione giusta")
        }
    }
        while (ControlloG==true)

}

fun Utente()
{

    var Controllo=true;

    // Richiedi nome e password dell'utente
    print("Inserisci il tuo nome utente: ")
    var utente1= readLine()!!.toString()
    print("Inserisci la tua password:")
    var password= readLine()!!.toString()

    if(utente1.equals(utente) && password.equals(pass))
    {
        do
        {
            if(Controllo==true)
            {
                println("-------MENU UTENTE------")
                println("Digita (1) per fare  il quizzone, (2) per uscire ?")
                var scelta= readLine()!!.toInt()
                if(scelta==1)
                {
                    var sizelista = listadomande.size
                    if(sizelista in 0 .. 2)
                        {
                            println("Il quiz non è pronto, riprova!")
                        }
                    else if(sizelista>=3)
                    {
                        var punteggio=0
                        for(i in 0 until sizelista)
                        {
                            //Visualizzo la domanda i
                            println("La domanda $i è la seguente: ${listadomande.get(i)}")
                            //Richiedo all'utente la risposta alla domanda i
                            print("Qual è la risposta a questa domanda? ")
                            var risposta= readLine()!!.toString()
                            //Controllo se la risposta dell'utente coincide con quella data dall'admin
                            if(risposta.equals(listarisposte.get(i)))
                                //Aumento il punteggio totale
                                    punteggio++
                        }
                        println("Hai risposto correttamente a $punteggio su ${listadomande.size}")
                    }

                }
                else if(scelta==2)
                {
                    println("Arrivederci!!")
                    Controllo=false
                }
                else if(scelta!=1 && scelta!=2)
                    println("Digita una scelta valida!")
            }
        }
        while(Controllo==true)
    }
    else
        println("Nome utente o password sbagliata! Riprova")

}

fun Admin()
{
    var Controllo=true;

    // Richiedi nome e password dell'utente
    print("Inserisci il tuo nome utente:")
    var utente1= readLine()!!.toString()
    print("Inserisci la tua password:")
    var password= readLine()!!.toString()

    //Controllo che l'utente e la password coincidano
    if(utente1.equals(admin) && password.equals(pass))
    {
        do
        {
            if (Controllo == true)
            {
                println("-------MENU ADMIN------")
                println("Digita (1) per aggiungere le domande al quizzone, (2) per rimuovere le domande, (3) per visualizzare e (4) per uscire?")
                var scelta= readLine()!!.toInt()
                if(scelta==1)
                {
                    //Richiedo all'admin la domanda da aggiungere
                    print("Digita la domanda che vuoi inserire (Ricordati il punto di domanda!): ")
                    var domanda= readLine()!!.toString()
                    //Inserisci la domanda nella listadomande
                    listadomande.add(domanda)
                    //Richiedo all'admin la riposta da aggiungere
                    print("Digita la risposta alla domanda appena inserita: ")
                    var risposta= readLine()!!.toString()
                    //Inserisci la domanda nella listarisposte
                    listarisposte.add(risposta)

                }
                else if(scelta==2)
                {
                    //Richiedo all'admin il numero della domanda da rimuovere
                    print("Digita il numero della domanda da rimuovere: ")
                    var rimuovere= readLine()!!.toInt()
                    //Controllo se l'array è vuoto
                    if(listadomande.size==0) {
                        println("Array vuoto, non puoi rimuovere nessun elemento")
                        break
                    }
                    else
                    {   //Rimuovo dalla lista delle domande/risposte quello che ho appena dichiarato nella variabile rimuovere
                        listadomande.removeAt(rimuovere)
                        listarisposte.removeAt(rimuovere)
                    }
                }
                else if(scelta==3)
                {
                    var i=0;
                    do
                    {
                        if(listadomande.size==0)
                        {
                            println("L'array è vuoto")
                            break
                        }
                        else {
                            print("La domanda $i è la seguente : ${listadomande.get(i)}     ")
                            println("La risposta $i è la seguente : ${listarisposte.get(i)}")
                            i++
                        }
                    }
                    while(i<listadomande.size)
                }
                else if(scelta==4)
                {
                    println("Arrivederci!!")
                    Controllo=false
                }
                else if (scelta!=1 && scelta!=2 && scelta!=3 && scelta!=4)
                    println("Digita una scelta valida!")
            }
        }
        while (Controllo == true)
    }
    else
        println("Nome utente o password sbagliata! Riprova")
}