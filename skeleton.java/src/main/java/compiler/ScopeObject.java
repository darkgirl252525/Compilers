package compiler;


class ScopeObject {
    private String name;
    private String type;
    private String genre;
    private boolean ref;
    private int scope;

    public ScopeObject(String name, String type,String genre, boolean ref ,int scope){
        this.name = name;
        this.type = type;
        this.genre = genre;
        this.ref = ref;
        this.scope = scope;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getGenre() {
        return genre;
    }

    public boolean getRef() {
        return ref;
    }

    public boolean sameObject(String name, String genre){    //an to name twn objects einai idio kai to ena object den einai function declaration return true

        if (this.getName().equals(name) && !genre.equals("decl") && !genre.equals("par_decl") ) {
            return true;
        }
        return false;
    }


    public boolean sameObjectPar(String name, String genre){  //an to name twn objects einai idio kai to ena object  einai function declaration return true

        if (this.getName().equals(name) && this.getGenre().equals(genre)  ) {
            return true;
        }
        else if(this.getName().equals(name) && genre.equals("decl"))
        {
            return true;
        }

        return false;
    }



    public boolean sameObjectFunc(String name, String genre){   //an exoume 2 synarthseis me idio onoma kai h mia dn einai dhlwsh ths allhs return true
        if (this.getName().equals(name) && genre.equals("func") && !this.getGenre().equals("decl") )
            return true;
        return false;
    }

    public void setGenre(String genre)
    {
        this.genre = genre;
    }

    public void setRef(boolean ref) {
        this.ref = ref;
    }

    public int getScope() {
        return scope;
    }
}
