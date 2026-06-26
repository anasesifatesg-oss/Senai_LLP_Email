public static int numUniqueEmails(String[] emails) {

    Set<String> emailsUnicos = new HashSet<>();

    for (String email : emails) {

        String[] partes = email.split("@");

        String nomeLocal = partes[0];
        String dominio = partes[1];

        int posicaoMais = nomeLocal.indexOf('+');

        if (posicaoMais != -1) {
            nomeLocal = nomeLocal.substring(0, posicaoMais);
        }

        nomeLocal = nomeLocal.replace(".", "");

        emailsUnicos.add(nomeLocal + "@" + dominio);
    }

    return emailsUnicos.size();
}

public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    System.out.print("Quantidade de e-mails: ");
    int quantidade = Integer.parseInt(sc.nextLine());

    String[] emails = new String[quantidade];

    for (int i = 0; i < quantidade; i++) {
        System.out.print("E-mail " + (i + 1) + ": ");
        emails[i] = sc.nextLine();
    }

    int resultado = numUniqueEmails(emails);

    System.out.println("\nQuantidade de e-mails únicos: " + resultado);

    sc.close();
}