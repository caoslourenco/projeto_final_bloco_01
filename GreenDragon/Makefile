# Nome do executável
NAME = GreenDragon

# Diretórios
MODEL_DIR = Model
REPOSITORY_DIR = Repository
CONTROLLER_DIR = Controller
UTILS_DIR = Utils

# Binários
JAVAC = javac
JAVA = java

# Diretório de saída
OUT_DIR = out

# Arquivos fonte
SRCS := $(wildcard $(MODEL_DIR)/*.java) \
        $(wildcard $(REPOSITORY_DIR)/*.java) \
        $(wildcard $(CONTROLLER_DIR)/*.java) \
        $(wildcard $(UTILS_DIR)/*.java) \
        Menu.java

# Objetos
OBJS := $(SRCS:%.java=$(OUT_DIR)/%.class)

# Alvo padrão
all: $(OUT_DIR)/$(basename $(notdir $(SRCS)))

# Regra de compilação
$(OUT_DIR)/%.class: %.java | $(OUT_DIR)
	$(JAVAC) -d $(OUT_DIR) $<

# Regra para criar diretório de saída
$(OUT_DIR):
	mkdir -p $(OUT_DIR)

# Regra para executar
run: all
	$(JAVA) -cp $(OUT_DIR) Menu

# Regra para limpar
clean:
	rm -rf $(OUT_DIR)

# Marca os alvos como phony (não são nomes de arquivos)
.PHONY: all run clean
