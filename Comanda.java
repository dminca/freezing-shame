public class Comanda implements java.io.Serializable{
    Pizza [] pizza = new Pizza[10];
    int n;
    
    public void adaugaPizza(Pizza p){
        if(n<pizza.length){
            this.pizza[n] = p;
            n++;
        }
    }
    
    public double getPretComanda(){
        double pretTotal = 0;
        for(int i=0;i<n;i++){
            pretTotal+=pizza[i].getPretTotal();
        }
        
        return pretTotal;
    }
    
    public Pizza getPizza(String nume){
        for(int i=0;i<n;i++){
            if(pizza[i].nume.equals(nume)) return pizza[i];
        }
        return null;
    }
}
