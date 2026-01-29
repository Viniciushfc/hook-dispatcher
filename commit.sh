#!/bin/bash

# Script de commit interativo seguindo Conventional Commits
# Uso: ./commit.sh

# Cores para output
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
BLUE='\033[0;34m'
PURPLE='\033[0;35m'
CYAN='\033[0;36m'
NC='\033[0m' # No Color

echo -e "${CYAN}"
echo "╔════════════════════════════════════════╗"
echo "║     COMMIT INTERATIVO - GIT            ║"
echo "╔════════════════════════════════════════╝"
echo -e "${NC}"

# 1. TIPO DO COMMIT
echo -e "${YELLOW}[1/3] Selecione o TIPO do commit:${NC}"
echo ""
echo "  1) feat       - Nova funcionalidade"
echo "  2) fix        - Correção de bug"
echo "  3) docs       - Documentação"
echo "  4) style      - Formatação de código"
echo "  5) refactor   - Refatoração"
echo "  6) perf       - Melhoria de performance"
echo "  7) test       - Testes"
echo "  8) build      - Build/dependências"
echo "  9) ci         - CI/CD"
echo " 10) chore      - Tarefas gerais"
echo ""
read -p "Digite o número: " tipo_num

case $tipo_num in
    1) tipo="feat" ;;
    2) tipo="fix" ;;
    3) tipo="docs" ;;
    4) tipo="style" ;;
    5) tipo="refactor" ;;
    6) tipo="perf" ;;
    7) tipo="test" ;;
    8) tipo="build" ;;
    9) tipo="ci" ;;
    10) tipo="chore" ;;
    *)
        echo -e "${RED}Opção inválida!${NC}"
        exit 1
        ;;
esac

echo -e "${GREEN}✓ Tipo selecionado: $tipo${NC}"
echo ""

# 2. ESCOPO DO COMMIT
echo -e "${YELLOW}[2/3] Digite o ESCOPO (opcional):${NC}"
read -p "> " escopo

if [ -n "$escopo" ]; then
    echo -e "${GREEN}✓ Escopo: $escopo${NC}"
else
    echo -e "${GREEN}✓ Sem escopo${NC}"
fi
echo ""

# 3. DESCRIÇÃO
echo -e "${YELLOW}[3/3] Digite a DESCRIÇÃO do commit:${NC}"
read -p "> " descricao

if [ -z "$descricao" ]; then
    echo -e "${RED}Descrição não pode ser vazia!${NC}"
    exit 1
fi

echo ""

# 5. MONTAR MENSAGEM
if [ -n "$escopo" ]; then
    mensagem_curta="$tipo($escopo): $descricao"
else
    mensagem_curta="$tipo: $descricao"
fi

# 6. PREVIEW
echo ""
echo -e "${CYAN}════════════════════════════════════════${NC}"
echo -e "${BLUE}Preview do commit:${NC}"
echo -e "${CYAN}════════════════════════════════════════${NC}"
echo -e "${GREEN}$mensagem_curta${NC}"
if [ -n "$corpo" ]; then
    echo ""
    echo "$corpo"
fi
echo -e "${CYAN}════════════════════════════════════════${NC}"
echo ""

# 7. CONFIRMAÇÃO
echo -e "${YELLOW}Confirmar commit? (S/n):${NC}"
read -p "> " confirma

if [[ "$confirma" =~ ^[Nn]$ ]]; then
    echo -e "${RED}Commit cancelado!${NC}"
    exit 0
fi

# 8. FAZER O COMMIT
if [ -n "$corpo" ]; then
    git commit -m "$mensagem_curta" -m "$corpo"
else
    git commit -m "$mensagem_curta"
fi

# 9. VERIFICAR SUCESSO
if [ $? -eq 0 ]; then
    echo ""
    echo -e "${GREEN}✓ Commit realizado com sucesso!${NC}"
    echo ""
    echo -e "${BLUE}Último commit:${NC}"
    git log -1 --oneline
else
    echo -e "${RED}✗ Erro ao fazer commit!${NC}"
    exit 1
fi