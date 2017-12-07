public class TestModulo{
	public static void main(String[] args){
		uthevRektangler(9, 9, 3, 3);
		
	}
	public static void uthevRektangler(int bredde, int hoyde, int rBredde, int rHoyde) { 
        int index =0;
		for (int i = 0; i < hoyde; i++) { 
            for (int j = 0; j < bredde; j++) { 
                if (((j / rBredde) % 2) == ((i / rHoyde) % 2)){
					if((j%rBredde)+(i%rHoyde)==0){
						index++;
                        
					}
					System.out.print(" ");
				}					
                else{
					if((j%rBredde)+(i%rHoyde)==0){
						index++;
                        
					}
					System.out.print("X");
				}
                     
            } 
            System.out.println(""); 
        }
		System.out.println(index);
    } 
}
