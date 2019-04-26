package nl.teundeclercq.portofolio.Context;

import nl.teundeclercq.portofolio.Interface.IPortfolioItem;
import nl.teundeclercq.portofolio.Models.PortfolioItem;

import java.sql.SQLException;
import java.util.List;

public class PortfolioItemMySQL extends DBconnection implements IPortfolioItem {
    @Override
    public List<PortfolioItem> getAllPortfolioItems() throws SQLException {
        return null;
    }

    @Override
    public PortfolioItem getPortfolioItem(Long id) throws SQLException {
        return null;
    }
}
