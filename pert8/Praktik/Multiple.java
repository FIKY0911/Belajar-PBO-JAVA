package pert8.Praktik;

interface Backend{
    public void connectServer();
}

class Frontend{
    public static void responsive(String str){
        System.out.println(str + " can also be used as frontend.");
    }
}

// Language extends Frontend class
// Language implements Backend interface
class Language extends Frontend implements Backend{
    String language = "Java";

    //impelent method of interface
    @Override
    public void connectServer(){
        System.out.println(language + " can be used as backend language.");
    }

    public static void main(String[] args){
        // create object of Languge class
        Language java = new Language();

        java.connectServer();
        // call the inheritance method of Frontend class
        java.responsive(java.language);
    }
}
