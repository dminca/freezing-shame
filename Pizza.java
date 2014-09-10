public class Pizza implements java.io.Serializable{
    String nume;
    double pret;
    Ingredient [] ingrediente;
    int n;
    
    public void adaugaIngredient(Ingredient i){
        if(n<ingrediente.length){
            ingrediente[n] = i;
            n++;
        }
    }
    
    public double getPretTotal(){
        double pretTotal = this.pret;
        
        for(int i=0;i<n;i++){
            pretTotal+= ingrediente[i].pret;
        }
        
        return pretTotal;
    }
}
