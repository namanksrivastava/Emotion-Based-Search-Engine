package DataPreProcessing.Crawler;

/**
 * Created by sanchitmehta on 05/12/16.
 */

/**
 * boilerpipe
 *
 * Copyright (c) 2009, 2014 Christian Kohlschütter
 *
 * The author licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
import java.net.URL;

import de.l3s.boilerpipe.BoilerpipeProcessingException;
import de.l3s.boilerpipe.extractors.ArticleExtractor;
import de.l3s.boilerpipe.extractors.CommonExtractors;
import de.l3s.boilerpipe.extractors.DefaultExtractor;

/**
 * Demonstrates how to use Boilerpipe to get the main content as plain text. Note: In real-world
 * cases, you'd probably want to download the file first using a fault-tolerant crawler.
 *
 * @see HTMLHighlightDemo if you need HTML as well.
 */
public class OneLiner {
    public static String getMainText(String htmlText) throws BoilerpipeProcessingException {
        String parsedText = ArticleExtractor.INSTANCE.getText(htmlText);
        //String parsedText = DefaultExtractor.INSTANCE.getText(htmlText);
        //String parsedText = CommonExtractors.CANOLA_EXTRACTOR.getText(htmlText);
        return parsedText;
    }


    public static void main(final String[] args) throws Exception {
        final URL url =
                new URL(
                        "www.google.com"
                        // "http://www.dn.se/nyheter/vetenskap/annu-godare-choklad-med-hjalp-av-dna-teknik"
                );

        System.out.println(ArticleExtractor.INSTANCE.getText(url));

        // Also try other extractors!
        // System.out.println(DefaultExtractor.INSTANCE.getText(url));
        // System.out.println(CommonExtractors.CANOLA_EXTRACTOR.getText(url));
    }
}
