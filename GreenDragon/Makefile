# Nome do executável
NAME = GreenDragon

# Compilador
CC = javac

# Flags do compilador
CFLAGS = -g

# Comando para remover arquivos
RM = rm -rf

# Diretórios
MODEL_DIR = Model
REPOSITORY_DIR = Repository
CONTROLLER_DIR = Controller
UTILS_DIR = Utils

# Arquivos fonte
SRCS = $(wildcard $(MODEL_DIR)/*.java) \
       $(wildcard $(REPOSITORY_DIR)/*.java) \
       $(wildcard $(CONTROLLER_DIR)/*.java) \
       $(wildcard $(UTILS_DIR)/*.java) \
       Menu.java

# Objetos
OBJS = $(SRCS:.java=.class)

# Alvo padrão
all: $(NAME)

# Regra de compilação
$(NAME): $(OBJS)
	$(CC) $(CFLAGS) $^ -o $@

# Regra para compilar os arquivos java
%.class: %.java
	$(CC) $(CFLAGS) -classpath $(MODEL_DIR):$(REPOSITORY_DIR):$(CONTROLLER_DIR):$(UTILS_DIR) -d . $<

# Regra para limpar arquivos
clean:
	$(RM) $(OBJS)

# Regra para limpar e recompilar
fclean: clean
	$(RM) $(NAME)

# Regra para reconstruir tudo
re: fclean all

# Marca os alvos como phony (não são nomes de arquivos)
.PHONY: all clean fclean re
