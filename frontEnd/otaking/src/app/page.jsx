import GreetingBanner from "@/components/GreetingBanner/GreetingBanner";
import NavCategory from "@/components/NavCategory/NavCategory";
import { Showcase } from "@/components/Showcase/Showcase";
import { getCategory } from "@/utils/apiClient";

export default async function Home() {
  const categories = ['manga', 'indumentaria', 'accesorios', 'figuras']
    .map(category => getCategory(category))

  const [
    manga,
    fabrics,
    accesories,
    figures,
  ] = await Promise.all(categories)

  return <main className="main">
    <GreetingBanner />
    <NavCategory />
    <Showcase name_category={'Manga'} items={manga} />
    <Showcase name_category={'Indumentaria'} items={fabrics} />
    <Showcase name_category={'Acessorios'} items={accesories} />
    <Showcase name_category={'Figuras'} items={figures} />
  </main>
}
