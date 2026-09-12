public class Main {
    static String normalizeReference(String raw) {
        String trimmed = raw.trim();
        String bankCode = trimmed.substring(0, 3).toUpperCase();
        String rest = trimmed.substring(3);
        return bankCode + rest;
    }

    static String validateAndFormat(String reference) {
        if (reference.length() != 14) {
            return "Invalid: reference must be exactly 14 characters";
        }

        String bankCode = reference.substring(0, 3);
        for (int i = 0; i < bankCode.length(); i++) {
            if (!Character.isLetter(bankCode.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        String body = reference.substring(3);
        for (int i = 0; i < body.length(); i++) {
            if (!Character.isDigit(body.charAt(i))) {
                return "Invalid: remaining characters must be digits";
            }
        }

        String date = reference.substring(3, 9);
        String seq = reference.substring(9, 14);

        String dd = date.substring(0, 2);
        String mm = date.substring(2, 4);
        String yy = date.substring(4, 6);

        StringBuilder sb = new StringBuilder();
        sb.append("[").append(bankCode).append("] DATE: ").append(dd).append("/").append(mm).append("/").append(yy)
          .append(" | SEQ: ").append(seq);
        return sb.toString();
    }

    public static void main(String[] args) {
        String raw1 = " hdf03022600042 ";
        String norm1 = normalizeReference(raw1);
        System.out.println(validateAndFormat(norm1));

        String raw2 = "12F03022600042";
        String norm2 = normalizeReference(raw2);
        System.out.println(validateAndFormat(norm2));
    }
}
