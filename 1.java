class LibraryMember {
    private String membershipPin;
    String branchCode;
    protected double finesOwed;
    public String displayName;
}

public class AccessChecker {
    static String classifyAccess(String fieldModifier, String accessorContext) {
        if (fieldModifier.equals("public")) {
            return "ALLOWED";
        }

        if (fieldModifier.equals("private")) {
            if (accessorContext.equals("SAME_CLASS")) {
                return "ALLOWED";
            }
            return "DENIED";
        }

        if (fieldModifier.equals("default")) {
            if (accessorContext.equals("SAME_CLASS") || accessorContext.equals("SAME_PACKAGE")) {
                return "ALLOWED";
            }
            return "DENIED";
        }

        if (fieldModifier.equals("protected")) {
            if (accessorContext.equals("SAME_CLASS") || accessorContext.equals("SAME_PACKAGE")) {
                return "ALLOWED";
            }
            return "DENIED";
        }

        return "DENIED";
    }

    static String summarizeByModifier(String[][] attempts) {
        String[] modifiers = {"private", "default", "protected", "public"};
        int[] allowedCounts = new int[4];
        int[] deniedCounts = new int[4];

        for (String[] attempt : attempts) {
            String result = classifyAccess(attempt[0], attempt[1]);
            for (int i = 0; i < modifiers.length; i++) {
                if (attempt[0].equals(modifiers[i])) {
                    if (result.equals("ALLOWED")) {
                        allowedCounts[i]++;
                    } else {
                        deniedCounts[i]++;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < modifiers.length; i++) {
            sb.append(modifiers[i]).append(": ").append(allowedCounts[i]).append(" allowed / ")
              .append(deniedCounts[i]).append(" denied");
            if (i != modifiers.length - 1) {
                sb.append(" | ");
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(classifyAccess("private", "SAME_CLASS"));
        System.out.println(classifyAccess("protected", "DIFFERENT_PACKAGE"));
        System.out.println(summarizeByModifier(new String[][]{
            {"private", "SAME_CLASS"},
            {"private", "SAME_PACKAGE"},
            {"default", "SAME_PACKAGE"},
            {"default", "DIFFERENT_PACKAGE"},
            {"protected", "SAME_PACKAGE"},
            {"protected", "SAME_CLASS"},
            {"public", "DIFFERENT_PACKAGE"}
        }));
    }
}
