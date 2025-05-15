package com.data.session08.controller.Bai9;

import com.data.session08.model.Bai8.Seeds;
import com.data.session08.model.Bai8.User;
import com.data.session08.model.FarmPlot;
import com.data.session08.model.WarehouseSeeds;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("loggedInUser")
public class GameController {

    private List<User> users = new ArrayList<>();
    private List<Seeds> seeds = new ArrayList<>();
    private List<WarehouseSeeds> warehouse = new ArrayList<>();

    public GameController() {
        seeds.add(new Seeds() {{
            setId(1);
            setSeedsName("Wheat");
            setPrice(50);
            setImageUrl("/images/wheat.jpg");
        }});
        seeds.add(new Seeds() {{
            setId(2);
            setSeedsName("Corn");
            setPrice(75);
            setImageUrl("/images/corn.jpg");
        }});
        seeds.add(new Seeds() {{
            setId(3);
            setSeedsName("Rice");
            setPrice(100);
            setImageUrl("/images/rice.jpg");
        }});
    }

    @PostMapping("/buy")
    public String buySeeds(@RequestParam("seedId") int seedId, @RequestParam("quantity") int quantity,
                           @SessionAttribute("loggedInUser") User loggedInUser, Model model) {
        Seeds selectedSeed = seeds.stream().filter(s -> s.getId() == seedId).findFirst().orElse(null);
        if (selectedSeed == null || quantity <= 0) {
            model.addAttribute("message", "Invalid seed or quantity.");
            return "redirect:/shop";
        }

        double totalCost = selectedSeed.getPrice() * quantity;
        if (loggedInUser.getBalance() < totalCost) {
            model.addAttribute("message", "Insufficient balance.");
            return "redirect:/shop";
        }

        loggedInUser.setBalance(loggedInUser.getBalance() - totalCost);

        WarehouseSeeds existingWarehouseSeed = warehouse.stream()
                .filter(ws -> ws.getSeeds().getId() == seedId)
                .findFirst()
                .orElse(null);

        if (existingWarehouseSeed != null) {
            existingWarehouseSeed.setQuantity(existingWarehouseSeed.getQuantity() + quantity);
        } else {
            WarehouseSeeds newWarehouseSeed = new WarehouseSeeds();
            newWarehouseSeed.setId(warehouse.size() + 1);
            newWarehouseSeed.setSeeds(selectedSeed);
            newWarehouseSeed.setQuantity(quantity);
            warehouse.add(newWarehouseSeed);
        }

        model.addAttribute("message", "Purchase successful!");
        return "redirect:/shop";
    }

    @GetMapping("/warehouse")
    public String showWarehouse(Model model) {
        model.addAttribute("warehouse", warehouse);
        return "warehouse";
    }
    @GetMapping("/farm")
    public String showFarm(Model model) {
        if (farm.isEmpty()) {
            for (int i = 1; i <= 20; i++) {
                farm.add(new FarmPlot(i, null));
            }
        }
        model.addAttribute("farm", farm);
        model.addAttribute("warehouse", warehouse);
        return "farm";
    }

    @PostMapping("/plant")
    public String plantSeed(@RequestParam("plotId") int plotId, @RequestParam("seedId") int seedId,
                            @SessionAttribute("loggedInUser") User loggedInUser, Model model) {
        FarmPlot selectedPlot = farm.stream().filter(p -> p.getId() == plotId).findFirst().orElse(null);
        WarehouseSeeds selectedSeed = warehouse.stream().filter(ws -> ws.getSeeds().getId() == seedId).findFirst().orElse(null);

        if (selectedPlot == null || selectedSeed == null || selectedSeed.getQuantity() <= 0) {
            model.addAttribute("message", "Invalid plot or seed selection.");
            return "redirect:/farm";
        }

        if (selectedPlot.getSeed() != null) {
            model.addAttribute("message", "This plot is already planted.");
            return "redirect:/farm";
        }

        selectedPlot.setSeed(selectedSeed.getSeeds());
        selectedSeed.setQuantity(selectedSeed.getQuantity() - 1);

        model.addAttribute("message", "Seed planted successfully!");
        return "redirect:/farm";
    }
}
