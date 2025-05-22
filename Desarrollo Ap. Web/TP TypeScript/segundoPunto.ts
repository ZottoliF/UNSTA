class IMC {
  peso: number;  
  altura: number;   

  constructor(peso: number, altura: number) {
    this.peso = peso;
    this.altura = altura;
  }

  calcularIMC(): number {
    return this.peso / (this.altura * this.altura);
  }
}