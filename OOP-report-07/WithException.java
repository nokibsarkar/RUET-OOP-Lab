class WithException {
    public static void main(String[] args) {
        try {
            int k = 0 / 0; // throws an ArithmeticException
        } catch (ArithmeticException e) {
            // handle the ArithmeticException
            System.out.println("Error Happened");
            System.out.println(e.getMessage());
        }
        System.out.println("Rest of the code");
    }
}