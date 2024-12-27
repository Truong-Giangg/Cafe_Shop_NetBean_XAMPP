package cafeshopmanagementsystem;
import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;


public class CafeShopController {

    @FXML
    private VBox shopList;

    @FXML
    private VBox shopEntryTemplate;

    @FXML
    private Label shopName;

    @FXML
    private Label shopAddress;

    @FXML
    private HBox starBox;

    @FXML
    private Label voteCount;

    // Sample data
    private static final CafeShop[] cafeShops = {
        new CafeShop("Downtown Café", "123 Main St", 150, 4),
        new CafeShop("Midtown Brew", "456 Center Rd", 200, 5),
        new CafeShop("Riverside Espresso", "789 River Ave", 120, 3)
    };

    @FXML
    public void initialize() {
        for (CafeShop shop : cafeShops) {
            VBox shopEntry = createShopEntry(shop);
            shopList.getChildren().add(shopEntry);
        }
    }

    private VBox createShopEntry(CafeShop shop) {
        // Clone the template
        VBox shopEntry = new VBox();
        shopEntry.setStyle(shopEntryTemplate.getStyle());
        shopEntry.setSpacing(shopEntryTemplate.getSpacing());

        // Clone and set the shop name
        Label clonedShopName = new Label(shop.getName());
        clonedShopName.setStyle(shopName.getStyle());

        // Clone and set the shop address
        Label clonedShopAddress = new Label(shop.getAddress());
        clonedShopAddress.setStyle(shopAddress.getStyle());

        // Clone and populate the star box
        HBox clonedStarBox = new HBox();
        clonedStarBox.setSpacing(starBox.getSpacing());
        for (int i = 1; i <= 5; i++) {
            ImageView star = createStarIcon(i <= shop.getRating());
            clonedStarBox.getChildren().add(star);
        }

        // Clone and set the vote count
        Label clonedVoteCount = new Label("Votes: " + shop.getVotes());
        clonedVoteCount.setStyle(voteCount.getStyle());

        // Add elements to the cloned entry
        shopEntry.getChildren().addAll(clonedShopName, clonedShopAddress, clonedStarBox, clonedVoteCount);
        return shopEntry;
    }

    private ImageView createStarIcon(boolean filled) {
        String starImagePath = filled ? "file:///C:/Users/phamv/Downloads/star.png" : "file:///C:/Users/phamv/Downloads/starEmpty.png";
        ImageView starIcon = new ImageView(new Image(starImagePath));
        starIcon.setFitWidth(20);
        starIcon.setFitHeight(20);
        return starIcon;
    }

}
