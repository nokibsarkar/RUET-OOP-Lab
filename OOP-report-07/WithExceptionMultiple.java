class WithExceptionMultiple  {
    public static void main(String[] args){
        try {
        int k = 0/0; // throws an ArithmeticException
        int[] a = new int[10];
        System.out.println(a[10]); // throws an ArrayIndexOutOfBoundsException
        
        } catch(ArithmeticException e){
            // handle the ArithmeticException
            System.out.println("Error Happened");
            System.out.println(e.getMessage());
        } catch(ArrayIndexOutOfBoundsException e){
            // handle the ArrayIndexOutOfBoundsException
            System.out.println("Indexing out of bound");
        }
        // Rest of the code
        System.out.println("Rest of the code");
    }
}