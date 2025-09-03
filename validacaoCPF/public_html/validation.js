/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/javascript.js to edit this template
 */

// --- MÁSCARA PARA CPF ---
const cpfInput = document.getElementById('CPF');

cpfInput.addEventListener('input', function () {
    let value = cpfInput.value.replace(/\D/g, ''); // remove tudo que não é número

    if (value.length > 11) value = value.slice(0, 11); // limita a 11 dígitos

    // Aplica a máscara
    value = value.replace(/(\d{3})(\d)/, '$1.$2');
    value = value.replace(/(\d{3})(\d)/, '$1.$2');
    value = value.replace(/(\d{3})(\d{1,2})$/, '$1-$2');

    cpfInput.value = value;
});

// --- MÁSCARA PARA TELEFONE ---
const telefoneInput = document.getElementById('telefone');

telefoneInput.addEventListener('input', function () {
    let value = telefoneInput.value.replace(/\D/g, ''); // remove tudo que não for número
    if (value.length > 11) value = value.slice(0, 11); // limita a 11 dígitos

    // Aplica a máscara
    if (value.length <= 10) {
        // Telefone fixo (10 dígitos)
        value = value.replace(/^(\d{2})(\d{4})(\d{0,4})/, '($1) $2-$3');
    } else {
        // Celular (11 dígitos)
        value = value.replace(/^(\d{2})(\d{5})(\d{0,4})/, '($1) $2-$3');
    }

    telefoneInput.value = value;
});

// --- VALIDAÇÃO DO FORMULÁRIO ---
document.getElementById('registrationForm').addEventListener('submit', function (event) {
    event.preventDefault(); // impede envio

    const cpf = cpfInput.value.replace(/\D/g, '');
    const nascimento = document.getElementById('dt_nascimento').value;
    const telefone = telefoneInput.value.replace(/\D/g, '');

    // --- VALIDAÇÃO CPF ---
    if (cpf.length !== 11) {
        alert("CPF inválido. Deve conter 11 dígitos.");
        return;
    }

    // --- VALIDAÇÃO DATA DE NASCIMENTO ---
    const dataNasc = new Date(nascimento);
    const hoje = new Date();
    if (isNaN(dataNasc.getTime())) {
        alert("Data de nascimento inválida.");
        return;
    }
    let idade = hoje.getFullYear() - dataNasc.getFullYear();
    const mesDiff = hoje.getMonth() - dataNasc.getMonth();
    if (mesDiff < 0 || (mesDiff === 0 && hoje.getDate() < dataNasc.getDate())) {
        idade--;
    }
    if (idade < 18) {
        alert("Você deve ter 18 anos ou mais.");
        return;
    }

    // --- VALIDAÇÃO TELEFONE ---
    if (telefone.length < 10 || telefone.length > 11) {
        alert("Telefone inválido. Deve conter 10 ou 11 dígitos.");
        return;
    }

    // --- FORMULÁRIO VÁLIDO: ABRIR MODAL DE SUCESSO ---
    $('#successModal').modal('show');

    // Limpa o formulário após envio
    this.reset();
});
