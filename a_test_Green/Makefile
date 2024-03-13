NAME= GreenDragon

SRCS= Menu.java Cores.java CadastroRepository.java CadastroController.java Silvestre.java Domestico.java Cadastro.java
OBJS= $(SRCS:.java=.class)



RM= rm -rf

JAVAC= javac
JAVAC_FLAGS= -Xlint:all Menu.java Cores.java CadastroRepository.java CadastroController.java Silvestre.java Domestico.java Cadastro.java

all: $(NAME)

$(NAME): $(OBJS)
	# Nenhuma ação necessária, já que os arquivos .class foram compilados

%.class: %.java
	$(JAVAC) $(JAVAC_FLAGS) $<

clean:
	$(RM) $(OBJS)

fclean: clean
	$(RM) $(NAME)

re: fclean all

.PHONY: all clean fclean re
