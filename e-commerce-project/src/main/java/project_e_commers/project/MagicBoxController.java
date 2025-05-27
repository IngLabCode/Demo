package project_e_commers.project;


import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/magicbox")
public class MagicBoxController {
    @Autowired
    private MagicWarehouse magicWarehouse;

    @GetMapping
    public List<ShopItem> getAllItems() {
        return magicWarehouse.findAll();
    }

    @PostMapping
    public ShopItem addItem(@RequestBody ShopItem item) {
        return magicWarehouse.save(item);
    }

    @GetMapping("/{id}")
    public ShopItem findOne(@PathVariable Long id) {
        return magicWarehouse.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public ShopItem editItem(@PathVariable Long id, @RequestBody ShopItem newItem) {
        return magicWarehouse.findById(id).map(item -> {
            item.setName(newItem.getName());
            item.setPrice(newItem.getPrice());
            item.setCategory(newItem.getCategory());
            item.setDescription(newItem.getDescription());
            return magicWarehouse.save(item);
        }).orElse(null);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        if (magicWarehouse.existsById(id)) {
            magicWarehouse.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping
    public List<ShopItem> getAllItems(@RequestParam(value = "search", required = false) String search) {
        if (search == null || search.isEmpty()) {
            return magicWarehouse.findAll();
        } else {
            return magicWarehouse.findByNameContainingIgnoreCaseOrCategoryContainingIgnoreCase(search, search);
        }
    }

}
