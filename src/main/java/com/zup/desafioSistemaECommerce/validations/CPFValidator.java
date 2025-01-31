package com.zup.desafioSistemaECommerce.validations;

public class CPFValidator {
    public static boolean isValidCPF(String cpf) {
        if (cpf == null || cpf.length() != 11 || cpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        try {
            int sum = 0;
            for (int i = 0; i < 9; i++) {
                sum += (cpf.charAt(i) - '0') * (10 - i);
            }
            int check1 = 11 - (sum % 11);
            if (check1 == 10 || check1 == 11) {
                check1 = 0;
            }
            if (check1 != (cpf.charAt(9) - '0')) {
                return false;
            }

            sum = 0;
            for (int i = 0; i < 10; i++) {
                sum += (cpf.charAt(i) - '0') * (11 - i);
            }
            int check2 = 11 - (sum % 11);
            if (check2 == 10 || check2 == 11) {
                check2 = 0;
            }
            return check2 == (cpf.charAt(10) - '0');
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
