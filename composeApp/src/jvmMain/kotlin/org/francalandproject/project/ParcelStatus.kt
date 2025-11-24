package org.francalandproject.project

enum class StatusPagamento {
    EM_DIA,     // pagamento dentro do prazo   Verde ✅
    PENDENTE,   // ainda não pago, dentro do prazo   Amarelo ⚠️
    ATRASADO    // não pago, passou do vencimento    Vermelho ❌
}