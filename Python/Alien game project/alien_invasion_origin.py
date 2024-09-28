import sys  # use tools in sys module to quit the game when the player quits.
import pygame  # a package
from settings import Settings


class AlienInvasion:
    """Overall class to manage game assets and behavior."""

    def __init__(self):
        """Initialize the game, and create game resources."""
        # TODO 1. Khởi tạo cài đặt nền cho pygame
        pygame.init()

        # TODO 2. Tạo cửa sổ hiển thị
        self.screen = pygame.display.set_mode((1600, 900))
        # đối tượng gán cho self.screen là 1 bề mặt, bề mặt được vẽ lại sau mỗi lần đi qua vòng lặp sự kiện
        # bề mặt được trả về bởi hàm display.set_mode là toàn bộ cửa sổ trò chơi

        pygame.display.set_caption("Alien Invasion")

        # Set back ground color
        self.background_color = (230, 230, 230)

    def run_game(self):  # trò chơi được điều khiển bởi phương thức run_game()
        """Start the main loop for the game."""
        while True:
            # TODO 3. While loop contain an event loop và code to manage screen updates.
            for event in pygame.event.get():
                # TODO 4. Hàm pygame.event.get() trả về các sự kiện diễn ra kể từ lần cuối cùng hàm này đc gọi
                if event.type == pygame.QUIT:
                    sys.exit()

            # tô màu bằng phương thức fill, hoạt động trên 1 bề mặt và nhận 1 đối số duy nhất
            self.screen.fill(self.background_color)

            pygame.display.flip()  # TODO 5. Yêu cầu pygame hiển thị màn hình được vẽ gần đây nhất
            # mỗi lần đi qua vòng while, nó vẽ một màn hình trống
            # xóa màn hình cũ và chỉ hiển thị màn hình mới nhất (tạo chuyển động mượt mà liên tục)


if __name__ == '__main__':
    # TODO 6. Make a game's object of the class, and run the game.
    ai = AlienInvasion()
    ai.run_game()

# Các module của pygame: event(f: get; type), display(f: set_mode; set_caption; flip)
