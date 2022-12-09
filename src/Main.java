import java.util.Scanner;
class BatallaHD {
    public static void main(String[] args) {
        int[][] SutableroJugador1 = new int[10][10];
        int[][] SutableroJugador2 = new int[10][10];
        Scanner HV1 = new Scanner(System.in);
        Scanner DV2 = new Scanner(System.in);
        System.out.println("Ingresa nombre del jugador 1");
        String nombreJugador1 = HV1.nextLine();
        int numeroBarcos1 = 0;
        int numeroBarcos2 = 0;
        boolean numeroBarcosValido1 = false;
        boolean numeroBarcosValido2 = false;
        do {
            System.out.println("Ingrese el numero de los barcos que desea colocar de 1 a 4");
            numeroBarcos1 = HV1.nextInt();
            if (numeroBarcos1 >= 1 && numeroBarcos1 <= 4) {
                numeroBarcosValido1 = true;
            } else {
                System.out.println("El numero de los barcos deben ser del 1 al 4");
            }
        } while (!numeroBarcosValido1);
        for (int i = 0; i < numeroBarcos1; i++) {
            System.out.println("Ingrese la posicion de su barco " + (i + 1) + " en el eje X (0-9)");
            int posicionX1 = HV1.nextInt();
            System.out.println("Ingrese la posicion de su barco " + (i + 1) + " en el eje Y (0-9)");
            int posicionY1 = HV1.nextInt();
            SutableroJugador1[posicionX1][posicionY1] = 1;
        }
        System.out.println("Ingrese  nombre del jugador 2");
        String nombreJugador2 = DV2.nextLine();
        numeroBarcos2 = 0;
        numeroBarcosValido2 = false;
        do {
            System.out.println("Ingrese el numero de barcos que desea colocar de 1 a 4");
            numeroBarcos2 = DV2.nextInt();
            if (numeroBarcos2 >= 1 && numeroBarcos2 <= 4) {
                numeroBarcosValido2 = true;
            } else {
                System.out.println("El numero de barcos debe ser del 1 al 4");
            }
        }
            while (!numeroBarcosValido2) ;
            for (int i = 0; i < numeroBarcos2; i++) {
                System.out.println("Ingrese la posicion de su barco " + (i + 1) + " en el eje X (0-9)");
                int posicionX2 = DV2.nextInt();
                System.out.println("Ingrese la posicion de su barco " + (i + 1) + " en el eje Y (0-9)");
                int posicionY2 = DV2.nextInt();
                SutableroJugador2[posicionX2][posicionY2] = 1;
            }
            boolean ganador = false;
            int puntosJugador1 = 0;
            int puntosJugador2 = 0;
            int[][] tirosJugador1 = new int[10][10];
            int[][] tirosJugador2 = new int[10][10];
            int turno = 1;
            while (!ganador) {
                if (turno == 1) {
                    System.out.println("Turno de " + nombreJugador1);
                    for (int i = 0; i < 10; i++) {
                        for (int j = 0; j < 10; j++) {
                            if (tirosJugador2[i][j] == 1) {
                                if (SutableroJugador1[i][j] == 1) {
                                    System.out.print("d");
                                } else {
                                    System.out.print("*");
                                }
                            } else {
                                if (SutableroJugador1[i][j] == 1) {
                                    System.out.print("v");
                                } else {
                                    System.out.print("+");
                                }
                            }
                        }
                        System.out.println();
                    }
                    System.out.println("Puntaje de " + nombreJugador1 + ": " + puntosJugador1);
                    System.out.println("Barcos que hay por hundir de " + nombreJugador2 + ": " + numeroBarcos2);
                    System.out.println("Ingrese la posicion de su tiro en el eje X (0-9)");
                    int posicionX1 = HV1.nextInt();
                    System.out.println("Ingrese la posicion de su tiro en el eje Y (0-9)");
                    int posicionY1 = HV1.nextInt();
                    if (tirosJugador1[posicionX1][posicionY1] == 1) {
                        System.out.println("tiro repetido, vuelve a tirar");
                    } else {
                        tirosJugador1[posicionX1][posicionY1] = 1;
                        if (SutableroJugador2[posicionX1][posicionY1] == 1) {
                            System.out.println("El Barco fue hundido");
                            puntosJugador1 += 22;
                            numeroBarcos2--;
                            if (numeroBarcos2 == 0) {
                                System.out.println("Ganaste " + nombreJugador1 +"****FELICIDADES****");
                                System.out.println("Puntaje de " + nombreJugador1 + ": " + puntosJugador1);
                                System.out.println("Barcos que hay por hundir de " + nombreJugador2 + ": " + numeroBarcos2);
                                System.out.println("Se muestra el tablero de " + nombreJugador1 + " con los barcos hundidos y tus tiros que fallo:");
                                for (int i = 0; i < 10; i++) {
                                    for (int j = 0; j < 10; j++) {
                                        if (tirosJugador1[i][j] == 1) {
                                            if (SutableroJugador2[i][j] == 1) {
                                                System.out.print("d");
                                            } else {
                                                System.out.print("*");
                                            }
                                        } else {
                                            if (SutableroJugador2[i][j] == 1) {
                                                System.out.print("v");
                                            } else {
                                                System.out.print("+");
                                            }
                                        }
                                    }
                                    System.out.println();
                                }
                                ganador = true;
                            }
                        } else {
                            System.out.println("Tiro al agua");
                        }
                        turno = 2;
                    }
                } else {
                    System.out.println("Turno de " + nombreJugador2);
                    for (int i = 0; i < 10; i++) {
                        for (int j = 0; j < 10; j++) {
                            if (tirosJugador1[i][j] == 1) {
                                if (SutableroJugador2[i][j] == 1) {
                                    System.out.print("d");
                                } else {
                                    System.out.print("*");
                                }
                            } else {
                                if (SutableroJugador2[i][j] == 1) {
                                    System.out.print("v");
                                } else {
                                    System.out.print("+");
                                }
                            }
                        }
                        System.out.println();
                    }
                    System.out.println("Puntaje de " + nombreJugador2 + ": " + puntosJugador2);
                    System.out.println("Barcos por hundir de " + nombreJugador1 + ": " + numeroBarcos1);
                    System.out.println("Ingrese la posicion del tiro en el eje X (0-9)");
                    int posicionX2 = DV2.nextInt();
                    System.out.println("Ingrese la posicion del tiro en el eje Y (0-9)");
                    int posicionY2 = DV2.nextInt();
                    if (tirosJugador2[posicionX2][posicionY2] == 1) {
                        System.out.println("tiro repetido, vuelve a tirar");
                    } else {
                        tirosJugador2[posicionX2][posicionY2] = 1;
                        if (SutableroJugador1[posicionX2][posicionY2] == 1) {
                            System.out.println("El Barco fue hundido");
                            puntosJugador2 += 22;
                            numeroBarcos1--;
                            if (numeroBarcos1 == 0) {
                                System.out.println("Ganaste " + nombreJugador2 +"****FELICIDADES****");
                                System.out.println("Puntaje de " + nombreJugador2 + ": " + puntosJugador2);
                                System.out.println("Barcos que hay por hundir de " + nombreJugador1 + ": " + numeroBarcos1);
                                System.out.println("Se muestra el tablero de " + nombreJugador1 + " con los barcos hundidos y tus tiros que fallo:");
                                for (int i = 0; i < 10; i++) {
                                    for (int j = 0; j < 10; j++) {
                                        if (tirosJugador2[i][j] == 1) {
                                            if (SutableroJugador1[i][j] == 1) {
                                                System.out.print("d");
                                            } else {
                                                System.out.print("*");
                                            }
                                        } else {
                                            if (SutableroJugador1[i][j] == 1) {
                                                System.out.print("v");
                                            } else {
                                                System.out.print("+");
                                            }
                                        }
                                    }
                                    System.out.println();
                                }
                                ganador = true;
                            }
                        } else {
                            System.out.println("Tiro al agua");
                        }
                        turno = 1;
                    }
                }
            }

    }
}