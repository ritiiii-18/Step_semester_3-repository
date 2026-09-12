public class Main {
    static String reverseCustomerName(String customerName) {
        StringBuilder reversed = new StringBuilder();

        for (int i = customerName.length() - 1; i >= 0; i--) {
            reversed.append(customerName.charAt(i));
        }

        return reversed.toString();
    }

    public static void main(String[] args) {
        String name = "Sunil";
        String reversedName = reverseCustomerName(name);

        System.out.println("Original Name: " + name);
        System.out.println("Reversed Name: " + reversedName);
    }
}
