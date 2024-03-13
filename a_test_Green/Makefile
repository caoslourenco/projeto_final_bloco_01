NAME=	GreenDragon

SRCS=	Menu.java Cores.java CadastroRepository.java CadastroController.java Silvestre.java Domestico.java Cadastro.java
OBJS=	$(SRCS:.java=.o)

RM=		rm -rf

CC=	c++
FLAGS =		-Wall -Werror -Wextra -std=c++98 -pedantic-errors

all:	$(NAME)

$(NAME):	$(OBJS)
	$(CC) $(FLAGS) $(OBJS) -o $(NAME)

%.o: %.java
	$(CC) $(FLAGS) -c $< -o $@

clean:
	$(RM) $(OBJS)

fclean: clean
	$(RM) $(NAME)

re: fclean all

.PHONY: all clean fclean re